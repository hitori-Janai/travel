# 黑马旅游网

![](./img/login_favorite2.gif)

## 技能点

* **前端**
  * html + css + js +bootstrap +  jq 
* **web层**
  * [Servlet](#Servlet):前端控制器
  * [Filter](#Filter):过滤器
  * [BeanUtils](#BeanUtils) : 数据封装
  * [Jackson](#Jackson): 序列化json工具 
* **service层**
* **Dao层**
  * [JdbcTemplate](#JdbcTemplate) : jdbc的工具
  * Mysql：数据库
  *  Druid：数据库连接池

### Servlet

>  post : ```request.setCharacterEncoding("utf-8");```

```java
response.setContentType("text/html;charset=UTF-8");
response.setContentType("application/json;charset=UTF-8");
```

### Filter

### BeanUtils 

> map自动封装到一个对象

```java
Map<String, String[]> map = request.getParameterMap();
User user = new User();
BeanUtils.populate(user, map);
```



### Jackson

> 将对象序列化为json

```java
String json = new ObjectMapper().writeValueAsString(obj);
```





### JdbcTemplate

> 查找单条

```java
String sql = "select * from tab_user where username = ?";
User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),username);
```

> 增 删 改

```template.update(sql);```



