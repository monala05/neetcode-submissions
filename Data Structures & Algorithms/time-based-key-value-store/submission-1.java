class TimeMap {
    class Pair{
        String value;
        int timeStamp;

        public Pair(String value, int timeStamp){
            this.value=value;
            this.timeStamp = timeStamp;
        }
    }

    HashMap<String, List<Pair>> tm;

    public TimeMap() {
        this.tm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp);
        
        if(tm.containsKey(key)){
            tm.get(key).add(pair);
        }else{
            List<Pair> cur = new ArrayList<>();
            cur.add(pair);
            tm.put(key, cur);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair> cur = tm.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = cur.size() - 1;
        String s = "";

        while(l <= r){
            int m = (l + r)/2;
            Pair pair = cur.get(m);
            if(pair.timeStamp <= timestamp){
                s = pair.value;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }

        return s;
    }
}
