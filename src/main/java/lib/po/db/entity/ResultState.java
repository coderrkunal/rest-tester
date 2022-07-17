package lib.po.db.entity;

public enum ResultState {
  NA("NA"),
  EXPECTED("expected"),
  UNEXPECTED ("unexpected");

  String val;
  ResultState(String string){
    val = string;
  }

  @Override public String toString() {
    return val;
  }
}
