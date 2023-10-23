package baseNoStates;

public class User {
  private final String name;
  private final String credential;

  //array de areas a las que puede ir

  //private Group group

  //metodo canAccess(area);

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
