package com.tb.algorithm.l21;


public class single {


        private static single single;

        private single() {

        }

        public static single getInstance() {
            if (null == single) {
                synchronized(single.class) {
                    if (null == single) {
                        return new single();
                    }
                    return single;
                }
            }
            return single;
        }

        static class InnerSingle {
            static single single = new single();
        }

}
