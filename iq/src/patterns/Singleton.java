package patterns;

public class Singleton {
  public static void main(String[] args) {
    Elvis theKing = Elvis.INSTANCE;
    theKing.hasLeftTheBuilding();
    
    AnotherElvis anotherKing = AnotherElvis.getInstance();
    anotherKing.hasLeftTheBuilding();
    
    EnumElvis enumElvis = EnumElvis.INSTANCE;
    enumElvis.hasLeftTheBuilding();  
  }
}

// With public static method.
class Elvis {
  public static final Elvis INSTANCE = new Elvis();
  private Elvis() {}
  
  public void hasLeftTheBuilding() {
    System.out.println("Elvis:Long live the king!");
  }
}

// With static factory.
class AnotherElvis {
  private static final AnotherElvis INSTANCE = new AnotherElvis();
  private AnotherElvis() {}
  
  public static AnotherElvis getInstance() { return INSTANCE; }
  
  public void hasLeftTheBuilding() {
    System.out.println("AnotherElvis: Long live the king!");
  }

}

// With Enum.
enum EnumElvis {
  INSTANCE;
  
  public void hasLeftTheBuilding() {
    System.out.println("EnumElvis:Long live the king!");
  }
}