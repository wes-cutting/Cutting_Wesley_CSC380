package edu.neumont.csc380.ds2.server;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 7/14/13
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MathLogic_2 {

    public double add(Number... params) {
        double sum = 0;
        for (Number n : params)
            sum += n.doubleValue();
        return sum;
    }

    public double subtract(Number... params) {
        double difference = params[0].doubleValue();

        Number[] copy = new Number[params.length - 1];
        System.arraycopy(params, 1, copy, 0, params.length - 1);

        for (Number n : copy)
            difference -= n.doubleValue();

        return difference;
    }
}
