class Solution {
    public int calPoints(String[] operations) {
        int[] stack = new int[operations.length];
        int p1 = 0;
        for(String op: operations ){
            
            if(op.equalsIgnoreCase("C")){
                p1--;
                stack[p1]=0;
            }else if(op.equalsIgnoreCase("D")){ 
                stack[p1]=stack[p1-1]*2;
                p1++;
            } else if (op.equalsIgnoreCase("+")){
                stack[p1]=stack[p1-1]+stack[p1-2];
                p1++;
            } else {
                // parse the int 
                int x = Integer.parseInt(op);
                stack[p1]=x;
                p1++;
            }
            //int t=total("op:"+op, stack);
            //System.out.print("op"+op+" t "+ t );
        }

        int t = 0;
        for(int r: stack){
            t+=r;
        }
        return t;
        // return total("End",stack);
    }

   
   private int total(String header, int[] results){
        StringBuffer sb = new StringBuffer("[");
        int result=0;
        for(int p: results){
            sb.append(p).append(",");
           result += p;
        }
        sb.append("]");
        System.out.println(header + sb.toString()+" t "+ result);
        return result;
   }
}