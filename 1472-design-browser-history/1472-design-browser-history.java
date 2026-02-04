class BrowserHistory {
    List<String> visitedUrls;
    int curUrl;
    int lastUrl;

    public BrowserHistory(String homepage) {
        visitedUrls = new ArrayList<>();
        visitedUrls.add(homepage);
        curUrl = 0;
    }
    
    public void visit(String url) {
        curUrl++;
        if(visitedUrls.size() > curUrl){
            visitedUrls.set(curUrl, url);
        }
        else{
            visitedUrls.add(url);
        }
        lastUrl = curUrl;
    }
    
    public String back(int steps) {
        curUrl = Math.max(0, curUrl - steps);
        return visitedUrls.get(curUrl);
    }
    
    public String forward(int steps) {
        curUrl = Math.min(lastUrl, curUrl + steps);
        return visitedUrls.get(curUrl);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */