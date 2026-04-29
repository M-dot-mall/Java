package model;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BolgDao {
    //新增一篇博客
    public void insert (Blog blog){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //建立链接
            connection = DBUtil.getConnection();
            //构造sql语句
            String sql = "insert into blog values (null,?,?,now(),?)";
            //使用sql语句
            statement = connection.prepareStatement(sql);
            statement.setString(1,blog.getTitle());
            statement.setString(2,blog.getContent());
            statement.setInt(3,blog.getUserId());
            //执行sql语句
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
    //查询所有的操作
    public List<Blog> getBlogs(){
        List<Blog> bloglist = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //建立连接
            connection = DBUtil.getConnection();
            //构造sql语句
            String sql = "select * from blog order by postTime desc";
            //使用sql语句
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogid(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                //正文是整个文章的内容，希望只显示一小部分
                //此处需要对content做一个简单的截断，这个截断的长度随意取
                String content = resultSet.getString("content");
                if(content.length()>100){
                    content = content.substring(0,100)+"...";
                }
                blog.setContent(content);
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                bloglist.add(blog);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            DBUtil.close(connection,statement,resultSet);
        }
        return bloglist;
    }
    //根据博客id查询指定博客
    public Blog getBlog(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            resultSet = statement.executeQuery();
            //由于拿到的是blogId进行查询，blogId作为主键，是唯一的
            //查询结果非0即1，不需要使用while来遍历
            if(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogid(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                return blog;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    //根据博客id删除博客
    public void delete(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
}
