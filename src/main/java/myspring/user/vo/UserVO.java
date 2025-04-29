package myspring.user.vo;

/*
 * Class(UserVO클래스) <=> Table(users 테이블) 
 * Object <=> Row(Record)
 * Variable <=> Column  
 */
public class UserVO {

	private Long id;
	private String userId;
	private String name;
	private String gender;
	private String city;

	public UserVO() {}

	public UserVO(String userId, String name, String gender, String city) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.city = city;
	}
	
	public UserVO(Long id, String userId, String name, String gender, String city) {
		this(userId,name,gender,city);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userId=" + userId + ", name=" + name + ", gender=" + gender + ", city=" + city
				+ "]";
	}

}
