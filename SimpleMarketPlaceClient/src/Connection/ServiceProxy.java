package Connection;

public class ServiceProxy implements Connection.Service {
  private String _endpoint = null;
  private Connection.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new Connection.ServiceServiceLocator()).getService();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Connection.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public java.lang.String update(java.lang.String name, int qt) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.update(name, qt);
  }
  
  public java.lang.String signUp(java.lang.String fname, java.lang.String lname, java.lang.String email, java.lang.String user, java.lang.String pwd) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signUp(fname, lname, email, user, pwd);
  }
  
  public java.lang.String updateSold(java.lang.String name, java.lang.String seller) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.updateSold(name, seller);
  }
  
  public java.lang.String updateBought(java.lang.String username, java.lang.String itemname) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.updateBought(username, itemname);
  }
  
  public java.lang.String advertise(java.lang.String name, java.lang.String description, java.lang.String seller, int price, int quantity) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.advertise(name, description, seller, price, quantity);
  }
  
  public java.lang.String getAdvertisement() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getAdvertisement();
  }
  
  public java.lang.String signIn(java.lang.String user, java.lang.String pass) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signIn(user, pass);
  }
  
  public java.lang.String getBought(java.lang.String tname) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getBought(tname);
  }
  
  public java.lang.String getSold(java.lang.String tname) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getSold(tname);
  }
  
  
}