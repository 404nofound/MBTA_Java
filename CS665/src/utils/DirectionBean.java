package utils;

import java.util.List;

/**
 *
 * @author Eddy
 */
public class DirectionBean {

    private List<RoutesBean> routes;

    public List<RoutesBean> getRoutes() {
        return routes;
    }

    public static class RoutesBean {

        private List<LegsBean> legs;

        public List<LegsBean> getLegs() {
            return legs;
        }

        public static class LegsBean {
            
            private DistanceBean distance;
            private DurationBean duration;
            private List<StepsBean> steps;

            public DistanceBean getDistance() {
                return distance;
            }

            public DurationBean getDuration() {
                return duration;
            }

            public List<StepsBean> getSteps() {
                return steps;
            }

            public static class DistanceBean {
                private String text;

                public String getText() {
                    return text;
                }
            }

            public static class DurationBean {
                private String text;

                public String getText() {
                    return text;
                }
            }

            public static class StepsBean {

                private DistanceBeanX distance;
                private DurationBeanX duration;
                private String html_instructions;

                public DistanceBeanX getDistance() {
                    return distance;
                }

                public DurationBeanX getDuration() {
                    return duration;
                }
                
                public String getHtml_instructions() {
                    return html_instructions;
                }

                public static class DistanceBeanX {
                    private String text;

                    public String getText() {
                        return text;
                    }
                }

                public static class DurationBeanX {
                    private String text;

                    public String getText() {
                        return text;
                    }
                }
            }
        }
    }
}