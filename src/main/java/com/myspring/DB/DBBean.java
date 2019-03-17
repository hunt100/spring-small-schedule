package com.myspring.DB;

import com.myspring.entities.Users;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class DBBean {
    String connectionURL;
    String connectionDB;
    String connectionUser;
    String connectionPassword;
    ArrayList<Users> users = new ArrayList<Users>();
    Connection connection;

    public DBBean() {

    }

    /*public void connect() {
        System.out.println("Initialize");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + getConnectionURL(), getConnectionUser(), getConnectionPassword());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

   // public void addUser(Users user) {
        /*try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `users`(`Id`, `login`, `password`, `roleId`) VALUES (NULL,?,?,?)");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getRoleId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    /*public Users ReturnUserById(Long Id) {
        /*Users retuser = null;
        try {
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM `users` WHERE Id = ?");
            prep.setLong(1, Id);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                retuser = new Users(rs.getLong("Id"), rs.getString("login"), rs.getString("password"), rs.getLong("roleId"));
            }
            prep.close();
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }*/
       // return retuser;
   /* }

    public Post ReturnPostById(Long id) {
        Post post = null;
        try {
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM `posts` WHERE post_id = ?");
            prep.setLong(1, id);
            PreparedStatement prep1 = connection.prepareStatement("SELECT * FROM `like_counts` WHERE post_id = ?");
            prep1.setLong(1,id);
            ResultSet rs = prep.executeQuery();
            ResultSet rs1 = prep1.executeQuery();
                while (rs.next() && rs1.next()) {
                    post = new Post(rs.getLong("post_id"), rs.getString("title"), rs.getString("Short_Content"), rs.getString("Content"), rs.getString("Added_date"), rs.getString("Author"));
                    post.SetLike(rs1.getInt("like_count"));
                }
            prep.close();
            prep1.close();
            rs.close();
            rs1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    public Users ReturnUserByLoginAndPassword(Users user) {
        Users retuser = null;
        try {
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM `users` WHERE login = ? AND password = ?");
            prep.setString(1, user.getLogin());
            prep.setString(2, user.getPassword());
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                retuser = new Users(rs.getLong("Id"), rs.getString("login"), rs.getString("password"), rs.getLong("roleId"));
            }
            prep.close();
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return retuser;
    }
    public void RemLike(Post post,Users user){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `like_counts` SET `like_count`=? WHERE `post_id` = ?");
            post.decrement();
            preparedStatement.setInt(1,post.getLike());
            preparedStatement.setLong(2,post.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("DELETE FROM `likes` WHERE `post_id` = ? AND `user_id`=?");
            preparedStatement.setLong(1,post.getId());
            preparedStatement.setLong(2,user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Post> Returnposts() {
        ArrayList<Post> posts = new ArrayList<Post>();
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM `posts`");
            PreparedStatement pr1 = connection.prepareStatement("SELECT * FROM `like_counts`");
            ResultSet rs = pr.executeQuery();
            ResultSet rs1 = pr1.executeQuery();
                while (rs.next() && rs1.next()) {
                    Post post = new Post(rs.getLong("post_id"), rs.getString("title"), rs.getString("Short_Content"), rs.getString("Content"), rs.getString("Added_date"), rs.getString("Author"));
                    post.SetLike(rs1.getInt("like_count"));
                    posts.add(post);
                }
            pr.close();
            rs.close();
            pr1.close();
            rs1.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }*/

    /*public boolean IsLiked(Post post,Users user)
    {
        try{
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM `likes` WHERE post_id=? AND user_id=?");
            prep.setLong(1,post.getId());
            prep.setLong(2,user.getId());
            ResultSet rs = prep.executeQuery();
            if(rs.next()) return true;
            prep.close();
            rs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public Post getPostbyId(Long id) {
        Post post = null;
        try {
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM `posts` WHERE post_id = ?");
            prep.setLong(1, id);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                post = new Post(rs.getLong("post_id"), rs.getString("title"), rs.getString("Short_Content"), rs.getString("Content"), rs.getString("Added_date"), rs.getString("Author"));
            }
            prep.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    public ArrayList<Comment> GetCommentsByPostId(Long id) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        try {
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM `comments` WHERE post_id = ?");
            prep.setLong(1, id);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(rs.getLong("com_id"), rs.getLong("post_id"), rs.getLong("user_id"), rs.getString("comment"), rs.getString("added_date"), rs.getString("login")));
            }
            prep.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public void AddComment(String comment, Users users, Post post) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `comments`(`com_id`, `post_id`, `user_id`, `comment`, `added_date`, `login`) VALUES (NULL,?,?,?,?,?)");
            preparedStatement.setLong(1, post.getId());
            preparedStatement.setLong(2, users.getId());
            preparedStatement.setString(3, comment);
            preparedStatement.setString(4, new Date().toString());
            preparedStatement.setString(5, users.getLogin());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeletComment(Long id) {
        try {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM `comments` WHERE com_id = ?");
            prep.setLong(1, id);
            prep.executeUpdate();
            prep.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddPost(Post post) {
        try {
            PreparedStatement prep = connection.prepareStatement("INSERT INTO `posts`(`post_id`, `title`, `Short_Content`, `Content`, `Added_date`, `Author`) VALUES(NULL,?,?,?,?,?)");
            prep.setString(1, post.getTitle());
            prep.setString(2, post.getShort_content());
            prep.setString(3, post.getContent());
            prep.setString(4, post.getAdded_date());
            prep.setString(5, post.getAuthor());
            prep.executeUpdate();
            prep.close();
            post = getPostbyTitle(post.getTitle());
            prep = connection.prepareStatement("INSERT INTO  `like_counts`(`id`,`post_id`,`like_count`) VALUES (NULL,?,0)");
            prep.setLong(1, post.getId());
            prep.executeUpdate();
            prep.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Post getPostbyTitle(String title)
    {
        Post post = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `posts` WHERE `title`= ?");
            preparedStatement.setString(1,title);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                post = new Post(rs.getLong("post_id"),null,null,null,null,null);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return post;
    }

    public void EditPost(Post post)
    {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `posts` SET title = ?,Short_Content=?,Content=?,Added_date=?,Author=? WHERE post_id = ?");
            preparedStatement.setString(1,post.getTitle());
            preparedStatement.setString(2,post.getShort_content());
            preparedStatement.setString(3,post.getContent());
            preparedStatement.setString(4,post.getAdded_date());
            preparedStatement.setString(5,post.getAuthor());
            preparedStatement.setLong(6,post.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void DeletePost(Long id)
    {

        try{
            PreparedStatement prep = connection.prepareStatement("DELETE FROM `posts` WHERE post_id = ?");
            prep.setLong(1,id);
            prep.executeUpdate();
            prep.close();
            prep = connection.prepareStatement("DELETE FROM `like_counts` WHERE post_id = ?");
            prep.setLong(1,id);
            prep.executeUpdate();
            prep.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void AddLike(Post post,Users user)
    {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `like_counts` SET `like_count`=? WHERE `post_id` = ?");
            post.IncrementLike();
            preparedStatement.setInt(1,post.getLike());
            preparedStatement.setLong(2,post.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("INSERT INTO `likes`(`id`,`post_id`,`user_id`) VALUES (NULL,?,?)");
            preparedStatement.setLong(1,post.getId());
            preparedStatement.setLong(2,user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public DBBean(String connectionURL, String connectionDB, String connectionUser, String connectionPassword) {
        this.connectionURL = connectionURL;
        this.connectionDB = connectionDB;
        this.connectionUser = connectionUser;
        this.connectionPassword = connectionPassword;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    public String getConnectionDB() {
        return connectionDB;
    }

    public void setConnectionDB(String connectionDB) {
        this.connectionDB = connectionDB;
    }

    public String getConnectionUser() {
        return connectionUser;
    }

    public void setConnectionUser(String connectionUser) {
        this.connectionUser = connectionUser;
    }

    public String getConnectionPassword() {
        return connectionPassword;
    }

    public void setConnectionPassword(String connectionPassword) {
        this.connectionPassword = connectionPassword;
    }

    public String getConnectionData(){
        return this.getConnectionURL() + "DB:" + this.getConnectionDB() + " " + this.getConnectionUser() + " " + this.getConnectionPassword();
    }*/
//}

