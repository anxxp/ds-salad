package Practice;


import java.io.IOException;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED

//DEFINE ANY CLASS AND METHOD NEEDED

//CLASS BEGINS, THIS CLASS IS REQUIRED

public class Solution2

{



    public static void main(String args[]) throws IOException{

        List<String> input = new ArrayList<String>();

        input.add("zid 9312");

        input.add("ip kindle book");

        input.add("asd echo show");

        input.add("asd alphabet");

        input.add("asd 123456");



        List<String> output = new Solution2().prioritizedOrders(5, input);

        System.out.println(output);

    }

//METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    public List<String> prioritizedOrders(int numOrders, List<String> orderList)

{

    List<Order> orderObjList = new ArrayList<Order>();

    for(int i=0; i< numOrders; i++) {

        orderObjList.add(new Order(i,orderList.get(i)));

    }

    Collections.sort(orderObjList);

    List<String> sortedOrderList = new ArrayList<String>();

    for(int i=0; i< numOrders; i++) {

        sortedOrderList.add(orderObjList.get(i).getOrderId());

    }

    return sortedOrderList;

}

//METHOD SIGNATURE ENDS

}



class Order implements Comparable<Order> {

    public Order(int orderSequence, String orderId) {

        this.orderId = orderId;

        String arr[] = orderId.split(" ", 2);



        this.idCode = arr[0];

        this.metadata = arr[1].trim();

        this.orderSequence = orderSequence;

    }



    private String orderId;



    private String idCode;

    private String metadata;

    int orderSequence;



    public String getOrderId() {

        return orderId;

    }



    public void setOrderId(String orderId) {

        this.orderId = orderId;

    }



    public String getIdCode() {

        return idCode;

    }



    public void setIdCode(String idCode) {

        this.idCode = idCode;

    }



    public String getMetadata() {

        return metadata;

    }



    public void setMetadata(String metadata) {

        this.metadata = metadata;

    }



    public int getOrderSequence() {

        return orderSequence;

    }



    public void setOrderSequence(int orderSequence) {

        this.orderSequence = orderSequence;

    }



    @Override

    public int compareTo(Order o) {

        if(isPrime(metadata)) {

            return this.getOrderId().compareTo(o.getOrderId());

        }

        else

        {

            return this.getOrderSequence()-o.getOrderSequence();

        }



    }



    private static boolean isPrime(String str) {

        try {

            Double.parseDouble(str);

            return false;

        } catch(NumberFormatException e){

            return true;

        }

    }



}