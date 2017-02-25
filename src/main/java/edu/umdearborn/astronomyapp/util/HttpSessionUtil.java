package edu.umdearborn.astronomyapp.util;

import java.util.Map;

import javax.servlet.http.HttpSession;

@SuppressWarnings("unchecked")
public final class HttpSessionUtil {

  public static final String COURSE_USER_KEY = "course-user-key";

  public static void putCourseUsers(HttpSession session, Map<String, String> map) {
    session.setAttribute(COURSE_USER_KEY, map);
  }

  public static Map<String, String> getCourseUsers(HttpSession session) {
    if (contains(session, COURSE_USER_KEY)) {
      return (Map<String, String>) getAttribute(session, COURSE_USER_KEY, Map.class);
    }
    return null;
  }

  public static String getCourseUserId(HttpSession session, String courseId) {
    String courseUserId = null;

    if (contains(session, COURSE_USER_KEY)) {
      Map<String, String> map =
          (Map<String, String>) getAttribute(session, COURSE_USER_KEY, Map.class);
      courseUserId = map.get(courseId);
    }

    if (courseUserId == null) {
      courseUserId = "";
    }

    return courseUserId;
  }

  public static boolean contains(HttpSession session, String key) {
    Object o = session.getAttribute(key);
    return o != null;
  }

  public static <T> T getAttribute(HttpSession session, String key, Class<T> type) {
    return castIfBelongsToType(session.getAttribute(key), type);
  }

  public static <T> T getAttributeOrDefault(HttpSession session, String key, Class<T> type,
      T defaultReturn) {
    if (contains(session, key)) {
      return getAttribute(session, key, type);
    }

    return defaultReturn;
  }

  public static <T> T castIfBelongsToType(Object o, Class<T> type) {
    if (o != null && type.isAssignableFrom(o.getClass())) {
      return type.cast(o);
    }
    return null;
  }

}
