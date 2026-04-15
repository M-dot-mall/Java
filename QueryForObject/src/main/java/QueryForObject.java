import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryForObject {
    public static List<Integer> queryForObject(){
        Connection connection = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        List<Integer>list = new ArrayList<>();
        connection =
        state = connection.prepareStatement(sql);
        for (int i = 0; i < params.length(); i++) {
            state.setObject(i+1,params[i]);
        }
        es = state.executeQuery();
        Res
    }
    public static void main(String[] args) {

    }
}
