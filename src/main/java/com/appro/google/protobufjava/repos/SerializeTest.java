package com.appro.google.protobufjava.repos;

import com.appro.google.protobufjava.generated.Test1OuterClass;

import java.io.FileOutputStream;

public class SerializeTest {

    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.err.println("Usage:  AddPerson ADDRESS_BOOK_FILE");
//            System.exit(-1);
//        }

        Test1OuterClass.Test1.Builder test1 =  Test1OuterClass.Test1.newBuilder();

        // Add an address.
        test1.setA(150);

        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream("testa");
        test1.build().writeTo(output);
        output.close();
    }
}
