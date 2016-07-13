/**
 * 
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Deepam
 *
 */
@Entity
@Table(name="User_auth")
public class User_auth {
	@Id
@GeneratedValue
	int userrollid;
	String useridname;
String role;

}
