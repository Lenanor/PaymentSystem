package PaymentSystem.Customer;

public class Customer
{
    private int customerId;
    private String firstName;
    private String lastLame;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String phoneNumber;

    public Customer(int customerId, String firstName, String lastLame, String streetName, String streetNumber, String postalCode, String city, String phoneNumber)
    {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastLame = lastLame;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerId()
    {
        return customerId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastLame()
    {
        return lastLame;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public String getStreetNumber()
    {
        return streetNumber;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getCity()
    {
        return city;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    @Override
    public String toString()
    {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastLame='" + lastLame + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
