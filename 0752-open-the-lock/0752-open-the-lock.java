class Solution {
    public List<String> getchild(String s){
        List<String> l=new ArrayList<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<4;i++){
            char c=arr[i];
            arr[i]=(char)('0'+(((c-'0')+1)%10));
            l.add(new String(arr));
            arr[i]=(char)('0'+(((c-'0')+9)%10));
            l.add(new String(arr));
            arr[i]=c;
        }
        return l;
    }
    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>();
        for(String s: deadends){
            if(s.equals("0000")) return -1;
            set.add(s);
        }
        if(target.equals("0000")) return 0;
        Deque<String> q=new ArrayDeque<>();
        int d=0;
        q.add("0000");
        set.add("0000");
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                for(String child: getchild(s)){
                    if(set.contains(child)) continue;
                    if(child.equals(target)) return d+1;
                    set.add(child);
                    q.add(child);
                }
            }
            d++;
        }
        return -1;
    }
}