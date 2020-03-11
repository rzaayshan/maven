package app.controller;

import app.entity.Flight;
import app.io.Console;
import app.io.ConsoleMain;
import app.service.Service;
import org.w3c.dom.ls.LSOutput;

public class Controller {
  Service service;
  Console console;

  public Controller(ConsoleMain console, Service service) {
    this.service = service;
    this.console = console;
  }

  public String show() {
    StringBuilder st= new StringBuilder();
   // return String.format("%s\n",service.getallFlights().toString());
    service.getallFlights().stream().forEach(s->st.append(String.format("%s\n",s)));
    return st.toString();
  }

  public String search(int id) {
    return service.getByid(id).toString();
  }

  public void book() {
    console.printLn("");
  }
}
