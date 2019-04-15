package etc.test2;

/**
 * @author choijaeyong on 15/04/2019.
 * @project Algorithm
 * @description
 * select sum(tiv_2012) from insurance
 * where
 *  pid in
 *    (select a.pid from insurance as a , insurance as b where a.tiv_2011 = b.tiv_2011 and a.lat != b.lat and a.lon != b.lon)
 *  and
 *  pid not in
 *    (select a.pid from insurance as a , insurance as b where a.tiv_2011 != b.tiv_2011 and a.lat = b.lat and a.lon = b.lon);
 *
 */
public class Solution6 {

}
