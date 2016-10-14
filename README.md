# ParcebleAndroid

Passing data with intent

Passing simple data types (String, int, double,…ect) between activities is easy. We can just put the them to intent with unique key and send it to an another activity.
But it is bit complex when passing custom objects between activities. This is the place where serialization comes.
What is Serialization?

Serialization is converting data from a fast, efficient, internal representation to something that can be kept in a persistent store or transmitted over a network.
Converting data to its serialized form is often called marshaling it. Converting it back to its live, in-memory representation is called deserializing or unmarshaling.
More about serialization - https://www.inkling.com/read/programming-android-mednieks-1st/chapter-6/serialization

In android there are two ways to achieve marshaling and unmarshaling of java objects
Serializable (Implment object as Serializable)
Parcelable (Implement object as Parcelable)
Serializable vs Parcelable

Serializable is a marker interface, which implies the user cannot marshal the data according to their requirements. So when object implements Serializable Java will automatically serialize it.
Parcelable is android own serialization protocol. In Parcelable, developers write custom code for marshaling and unmarshaling. So it creates less garbage objects in comparison to Serialization
The performance of Parcelable is very high when comparing to Serializable because of its custom implementation
It is highly recommended to use Parcelable implantation when serializing objects in android

## Getting Started

You will have to download the project and run it on your local machine.

### Prerequisities

Everything you need in order to use this code is inside the project you may only need to update the gradle plugin and the libs.

## Built With

Android Studio 2.2

## More Info

More info about Serilization -> https://en.wikipedia.org/wiki/Serialization

More info about Parceble -> https://www.inkling.com/read/programming-android-mednieks-1st/chapter-6/serialization

## Authors

* **Niki Izvorski ** - *Initial work*
