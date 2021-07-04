package Week2.Case;

import java.util.HashMap;
import java.util.Map;

/**
 * 内存泄漏例子
 */
public class KeylessEntry {
    static class Key{
        Integer id;
        Key(Integer id){
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        /**
         * 无此方法时，内存将泄漏，m.size()的值将无限增长，直到OOM
         * 有此方法时，内存不泄露，m.size()的值最大增长到10000，最后将不停的输出：m.size()=10000
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            boolean response = false;
            if(obj instanceof Key){
                response = (((Key)obj).id).equals(this.id);
            }
            return response;
        }
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        while (true){
            for (int i=0;i<10000;i++){
                if(!m.containsKey(new Key(i))){
                    m.put(new Key(i),"Number:"+i);
                }
            }
            System.out.println("m.size()="+m.size());
        }
    }
}
