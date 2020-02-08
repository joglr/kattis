interface Testable {

  String getTestsFolder();

  void init(String line);

  int getTestCount();

  int receiveInput(String line);

  String getOut();

}
