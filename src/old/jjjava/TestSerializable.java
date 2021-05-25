package old.jjjava;

import java.io.*;

/**
 * @Author : LoneKing
 * @Description:
 * @Date: Created in 9:16 2020/1/12
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public class TestSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setId("1");
        user.setUserName("user1");
        FileOutputStream fos = new FileOutputStream("F:\\test.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(user);
        os.writeInt(65535);
        os.flush();

        FileInputStream fis = new FileInputStream("F:\\test.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        User user1 = (User) is.readObject();
        int n = is.readInt();

        fos.close();
        os.close();
        fis.close();
        is.close();
    }

}

class User implements Serializable {
    public User() {
    }

    private String id;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}