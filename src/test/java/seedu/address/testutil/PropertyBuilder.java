package seedu.address.testutil;

import seedu.address.model.address.Address;
import seedu.address.model.characteristics.Characteristics;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.property.Description;
import seedu.address.model.property.Owner;
import seedu.address.model.property.Price;
import seedu.address.model.property.Property;
import seedu.address.model.property.PropertyName;

/**
 * A utility class to help with building Property objects.
 */
public class PropertyBuilder {

    public static final String DEFAULT_NAME = "Peak Residence";
    public static final String DEFAULT_PRICE = "3000000";
    public static final String DEFAULT_ADDRESS = "333 Thompson Road";
    public static final String DEFAULT_DESCRIPTION = "A 5-storey condo on top of a hill - "
            + "Peak Residence offers you serenity away from the hustle and bustle with breathtaking views all around.";
    public static final String DEFAULT_OWNER_NAME = "John Doe";
    public static final String DEFAULT_OWNER_PHONE = "94351253";

    private PropertyName name;
    private Price price;
    private Address address;
    private Description description;
    private Owner owner;
    private Characteristics characteristics;

    /**
     * Creates a {@code PropertyBuilder} with the default details.
     */
    public PropertyBuilder() {
        name = new PropertyName(DEFAULT_NAME);
        price = new Price(DEFAULT_PRICE);
        description = new Description(DEFAULT_DESCRIPTION);
        address = new Address(DEFAULT_ADDRESS);
        characteristics = null;
        owner = new Owner(new Name(DEFAULT_OWNER_NAME), new Phone(DEFAULT_OWNER_PHONE));
    }

    /**
     * Initializes the PropertyBuilder with the data of {@code propertyToCopy}.
     */
    public PropertyBuilder(Property propertyToCopy) {
        name = propertyToCopy.getPropertyName();
        price = propertyToCopy.getPrice();
        description = propertyToCopy.getDescription();
        address = propertyToCopy.getAddress();
        owner = propertyToCopy.getOwner();
        characteristics = propertyToCopy.getCharacteristics().orElse(null);
    }

    /**
     * Sets the {@code Name} of the {@code Property} that we are building.
     */
    public PropertyBuilder withName(String name) {
        this.name = new PropertyName(name);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Property} that we are building.
     */
    public PropertyBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Price} of the {@code Property} that we are building.
     */
    public PropertyBuilder withPrice(String price) {
        this.price = new Price(price);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Property} that we are building.
     */
    public PropertyBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /**
     * Sets the {@code Owner} of the {@code Property} that we are building.
     */
    public PropertyBuilder withOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Sets the {@code characteristics} of the {@code Property} that we are building.
     */
    public PropertyBuilder withCharacteristics(String characteristics) {
        this.characteristics = new Characteristics(characteristics);
        return this;
    }

    /**
     * Removes the {@code characteristics} of the {@code Property} that we are building.
     */
    public PropertyBuilder withNoCharacteristics() {
        this.characteristics = null;
        return this;
    }

    public Property build() {
        return new Property(name, price, address, description, characteristics, owner);
    }
}
