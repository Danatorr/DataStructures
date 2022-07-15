import java.util.LinkedList;
import java.util.List;

public class Stack {

    private List<Object> datas = new LinkedList<Object>();

    public void insert(Object data) {
        datas.add(data);
    }

    public Object remove() {
        return datas.remove(datas.size() - 1);
    }

    public boolean empty() {
        //return datas.isEmpty();
        return datas.size() == 0;
    }

    @Override
    public String toString() {
        return datas.toString();
    }
}
