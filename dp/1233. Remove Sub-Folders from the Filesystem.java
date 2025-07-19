class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        int n = folder.length;
        for(int i=0;i<n;i++){
            if(res.isEmpty())res.add(folder[i]);
            else{
                String prev = res.get(res.size()-1);
                if(folder[i].startsWith(prev) && folder[i].length() > prev.length() && folder[i].charAt(prev.length())=='/'){
                    continue;
                }else{
                    res.add(folder[i]);
                }
            }
        }
        return res;
    }
}
