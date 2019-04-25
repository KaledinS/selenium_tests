package automationpractice.com.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Objects;
@XStreamAlias("data")
public class DataRegistration {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String password;
    @Expose
    private String company;
    @Expose
    private String adress;
    @Expose
    private String city;
    @Expose
    private String postcode;
    @Expose
    private String phoneMobile;
    @Expose
    private String phone;
    @Expose
    private String aliasAdress;
    @Expose
    private String email;



    public DataRegistration setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public DataRegistration setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public DataRegistration setPassword(String password) {
        this.password = password;
        return this;
    }
    public DataRegistration setEmail(String email) {
        this.email = email;
        return this;
    }
    public DataRegistration setCompany(String company) {
        this.company = company;
        return this;
    }

    public DataRegistration setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public DataRegistration setCity(String city) {
        this.city = city;
        return this;
    }

    public DataRegistration setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public DataRegistration setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
        return this;
    }

    public DataRegistration setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public DataRegistration setAliasAdress(String aliasAdress) {
        this.aliasAdress = aliasAdress;
        return this;
    }


    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany() {
        return company;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getPhone() {
        return phone;
    }

    public String getAliasAdress() {
        return aliasAdress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRegistration that = (DataRegistration) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(company, that.company) &&
                Objects.equals(adress, that.adress) &&
                Objects.equals(city, that.city) &&
                Objects.equals(postcode, that.postcode) &&
                Objects.equals(phoneMobile, that.phoneMobile) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(aliasAdress, that.aliasAdress) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,
                lastName, password, company, adress, city,
                postcode, phoneMobile, phone, aliasAdress, email);
    }

    @Override
    public String toString() {
        return "DataRegistration{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", company='" + company + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", phone='" + phone + '\'' +
                ", aliasAdress='" + aliasAdress + '\'' +
                '}';
    }

}
