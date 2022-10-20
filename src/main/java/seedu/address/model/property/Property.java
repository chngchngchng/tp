package seedu.address.model.property;


import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Optional;

import seedu.address.model.address.Address;
import seedu.address.model.characteristics.Characteristics;

/**
 * Represents a Property in the address book.
 * Guarantees: field values are validated, immutable.
 * Only characteristics may be null.
 */
public class Property {

    // TODO: Remove description and tags fields

    // Identity fields
    private final PropertyName propertyName;
    private final Price price;

    // Data fields
    private final Address address;
    private final Description description;
    private final Optional<Characteristics> characteristics;

    // private final Seller seller;
    private final String seller; // TODO: change to Seller object

    /**
     * Every field must be present and not null.
     */
    public Property(PropertyName propertyName, Price price, Address address, Description description,
                    String seller, Characteristics characteristics) {
        requireAllNonNull(propertyName, price, address, description, seller);
        this.propertyName = propertyName;
        this.price = price;
        this.address = address;
        this.description = description;
        this.seller = seller;
        this.characteristics = Optional.ofNullable(characteristics);
    }

    public PropertyName getName() {
        return propertyName;
    }

    public Address getAddress() {
        return address;
    }

    public Price getPrice() {
        return price;
    }

    public Description getDescription() {
        return description;
    }

    public String getSeller() {
        return seller;
    }

    public Optional<Characteristics> getCharacteristics() {
        return this.characteristics;
    }

    /**
     * Returns true if both properties have the same name and price.
     * This defines a weaker notion of equality between two properties.
     */
    public boolean isSameProperty(Property otherProperty) {
        if (otherProperty == this) {
            return true;
        }

        return otherProperty != null
                && otherProperty.getName().equals(getName())
                && otherProperty.getPrice().equals(getPrice());
    }

    /**
     * Returns true if both properties have the same identity and data fields.
     * This defines a stronger notion of equality between two properties.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Property)) {
            return false;
        }

        Property otherProperty = (Property) other;
        return otherProperty.getName().equals(getName())
                && otherProperty.getPrice().equals(getPrice())
                && otherProperty.getAddress().equals(getAddress())
                && otherProperty.getDescription().equals(getDescription())
                && otherProperty.getSeller().equals(getSeller())
                && otherProperty.getCharacteristics().equals(getCharacteristics());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(propertyName, price, address, description, seller);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Address: ")
                .append(getAddress())
                .append("; Price: ")
                .append(getPrice())
                .append("; Description: ")
                .append(getDescription())
                .append("; Seller: ")
                .append(getSeller());

        builder.append("; Characteristics: ")
                .append(getCharacteristics()
                        .map(Characteristics::toString)
                        .orElse("Not Specified"));
        return builder.toString();
    }

}
