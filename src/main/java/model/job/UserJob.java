package model.job;

import java.io.File;

import model.custom.UserCustom;

public interface UserJob {
public boolean ValidateAndCreateUser(String nom, String prenom, String email, String tel, String mdp,String adresse) throws Exception;
public boolean UpdatePicture(File file, UserCustom user) throws Exception;
public UserCustom ConnectUser(String login,String mdp)throws Exception;
public void CheckEmail( String email ) throws Exception;
public boolean  updatUser(UserCustom user)throws Exception;
public boolean IsNew(String email)throws Exception;
public UserCustom getUser(String login, String mdp) throws Exception;
public void CheckMdp( String mdp2 ) throws Exception;

}
