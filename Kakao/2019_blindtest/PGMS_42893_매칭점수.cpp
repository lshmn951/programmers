#include <bits/stdc++.h>
using namespace std;

struct Web{
    int idx;
    double score;
    int link;
};
bool cmp(Web p1, Web p2) {
    if (p1.score == p2.score)
        return p1.idx < p2.idx;
    else
        return p1.score > p2.score;
}
void makeUpper(string &str){
    for(int i=0;i<str.length();i++){
        str[i] = toupper(str[i]);
    }
}

string findUrl(string preUrl,string html){
    string endUrl = "\"/>";
    int s = html.find(preUrl)+preUrl.length();
    int e = html.substr(s).find(endUrl);
    
    return html.substr(s,e);
}
int findLinkCnt(string preLink,string html){
    int count =0;
    while(true){
        int s = html.find(preLink);
        if(s==-1){
            break;
        }
        count++;
        html = html.substr(s+1);
    }
    return count;
}
pair<string,int> findLink(string preLink,string html){
    string link = "";
    string endLink ="\">";
    int s = html.find(preLink);
    if(s==-1){
        return {link,-1};
    }else{
        int e = html.substr(s).find(endLink);
        link = html.substr(s+preLink.length(),e-preLink.length());
        return {link,s+e};
    }
}

int findWordCount(string word,string html){
    int count =0;
    makeUpper(word);
    html = html.substr(html.find("<body>")+7);
    html = html.substr(0,html.find("</body>"));
    makeUpper(html);
    while(true){
        int s = html.find(word);
        if(s==-1){
            break;
        }
        
        if(isalpha(html[s-1])||isalpha(html[s+word.length()])){
            html = html.substr(s+1);
            continue;
        }
        count++;
        html = html.substr(s+1);
    }
    return count;
}

int solution(string word, vector<string> pages) {
    
    int answer = 0;
    string preUrl = "<meta property=\"og:url\" content=\"https://";
    string preLink = "<a href=\"https://";
    map<string, Web > Webs;
    vector<string> pageUrl;
    for(int i=0;i<pages.size();i++){
        string fUrl = findUrl(preUrl,pages[i]);
        double score = findWordCount(word,pages[i]);
        int cnt = findLinkCnt(preLink,pages[i]);
        Web temp;
        temp.idx = i;
        temp.score = score;
        temp.link = cnt;
        Webs[fUrl] = temp;
        pageUrl.push_back(fUrl);
    }
    vector<double > plus(pages.size(),0);
    for(int i=0;i<pages.size();i++){
        pair<string,int> elink;
        Web temp = Webs[pageUrl[i]];
        pages[i] = pages[i].substr(pages[i].find("<body>")+7);
        while(true){
            elink = findLink(preLink,pages[i]);
            if(elink.second==-1){
                break;
            }
            if(Webs.find(elink.first)!=Webs.end()){
                int id = Webs[elink.first].idx;
                plus[id] += temp.score/temp.link;
            }
            pages[i] = pages[i].substr(elink.second);
        }
    }
    for(auto m:Webs){
        int id = m.second.idx;
        Webs[m.first].score += plus[id];
    }

    vector<Web> res;
    for(auto m:Webs){
        res.push_back(m.second);
    }
    sort(res.begin(),res.end(),cmp);
    answer = res[0].idx;
    return answer;
}

int main(){
    vector<string> pages1 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
    vector<string> pages2 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
    cout << solution("blind",pages1) << "\n";
    cout << solution("Muzi",pages2) << "\n";
}