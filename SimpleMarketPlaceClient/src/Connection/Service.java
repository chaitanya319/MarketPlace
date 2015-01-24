/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public interface Service extends java.rmi.Remote {
    public java.lang.String update(java.lang.String name, int qt) throws java.rmi.RemoteException;
    public java.lang.String signUp(java.lang.String fname, java.lang.String lname, java.lang.String email, java.lang.String user, java.lang.String pwd) throws java.rmi.RemoteException;
    public java.lang.String updateSold(java.lang.String name, java.lang.String seller) throws java.rmi.RemoteException;
    public java.lang.String updateBought(java.lang.String username, java.lang.String itemname) throws java.rmi.RemoteException;
    public java.lang.String advertise(java.lang.String name, java.lang.String description, java.lang.String seller, int price, int quantity) throws java.rmi.RemoteException;
    public java.lang.String signIn(java.lang.String user, java.lang.String pass) throws java.rmi.RemoteException;
    public java.lang.String getAdvertisement() throws java.rmi.RemoteException;
    public java.lang.String getBought(java.lang.String tname) throws java.rmi.RemoteException;
    public java.lang.String getSold(java.lang.String tname) throws java.rmi.RemoteException;
}
