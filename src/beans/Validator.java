package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class Validator {
	private String nick;
	private String pass;
	private int age;
	private String email;
	private String email2;

	// Getters & setters
	public void validatorNick(FacesContext context,
			UIComponent componentToValidate, Object value)
			throws ValidatorException {
		String id = (String) value;
		if (id.equals("nick") || id.equals("admin")) {
			FacesMessage message = new FacesMessage("nick reservado");
			throw new ValidatorException(message);
		}
	}

	public String process() {
		// Se valida con la capa de negocio o se relacionan campos
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.getNick().equals(this.getPass()))
			context.addMessage("form", new FacesMessage(
					"La clave no debe coincidir con el nick"));
		if (context.getMessageList().size() > 0)
			return (null);
		else
			return ("validatorOk");
	}
	
	public String validatorEmail2() {
		// Se valida con la capa de negocio o se relacionan campos
		FacesContext context = FacesContext.getCurrentInstance();
		if (!(this.getEmail2().equals(this.getEmail())))
			context.addMessage("form", new FacesMessage(
					"Email2debe coincidir con el email"));
		if (context.getMessageList().size() > 0)
			return (null);
		else
			return ("validatorOk");
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

}
