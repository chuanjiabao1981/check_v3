package com.check.v3.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
@Table(name = "users")
public class User implements Serializable {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(User.class);

	private static final long serialVersionUID = -15913810676325L;
	
	private long 	id;
	private int 	version; 
	private String 	name;
	private String  account;
	private String 	password_cryp;
	
	@Id
	@GeneratedValue(strategy = IDENTITY) 
	@Column(name = "id")
	public long getId() {
		return id;
	}
	
	@Column(name = "version")
	public int getVersion() {
		return version;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	@Column(name="password_cryp")
	public String getPassword_cryp() {
		return password_cryp;
	}
	
	@Column(name="account")
	public String getAccount() {
		return account;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword_cryp(String password_cryp) {
		this.password_cryp = password_cryp;
	}
	
	public void setPassword(String password)
	{
		RealmSecurityManager realmSecurityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		if (realmSecurityManager == null){
			logger.warn("RealmSecurityManager is not found!");
			return;
		}
		Collection<Realm> realms = realmSecurityManager.getRealms();
		if (realms == null || realms.size() == 0){
			logger.warn("Realms is null!");
			return;
		}
		AuthorizingRealm realm = (AuthorizingRealm) realms.iterator().next();
		PasswordMatcher	 passwordMatcher = (PasswordMatcher) realm.getCredentialsMatcher();
		setPassword_cryp(passwordMatcher.getPasswordService().encryptPassword(password));		
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public boolean equals(Object obj)
	{
		if (!(obj instanceof User)){
			return false;
		}
		User other = (User) obj;
		if (other.getAccount() != null){
			if (other.getAccount().equals(this.account)){
				return true;
			}
		}else{
			if (this.account == null){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	
	

}
