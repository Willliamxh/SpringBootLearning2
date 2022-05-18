package com.bjp.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @Author Willam_xh
 * @Date 2022-05-17 19:32
 */
@RestController
public class RedisController {

    /**
     * 注入RedisTemplate
     *
     * RedisTemplate 泛型
     * RedisTemplate<String,String>
     * RedisTemplate<Object,Object>
     * RedisTemplate
     *
     * 注意： RedisTemplate对象的名称 redisTemplate
     * 因为springboot框架创建这个类的对象默认就是这个名字，这样直接按照名称创建对象 然后进行赋值注入
     */
    @Resource
    private RedisTemplate redisTemplate;


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //添加数据到redis
    //使用postman设定对应的参数和地址
    //http://localhost:9001/myredis/redis/addString?name=myname&value=lisi
    @PostMapping("/redis/addString")
    public String addToRedis(String name,String value){
        // 操作Redis中string类型的数据， 先获取ValueOperations对象
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //添加数据到redis
        valueOperations.set("myname","lisi");

        return "向redis添加String类型的数据";
    }



    //从redis获取数据
    @GetMapping("/redis/getk")
    public String getData(String k){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(k);
        return "key是"+k+",他的值为"+v;
    }

    @PostMapping("/redis/{k}/{v}")
    public String addStringKV(@PathVariable String k,
                              @PathVariable String v){
        //使用StringRedisTemplate对象
        stringRedisTemplate.opsForValue().set(k,v);
        return "使用stringRedisTemplate对象";
    }

    @GetMapping("/redis/getstr/{k}")
    public String getSringValue(@PathVariable String k){
        String v = stringRedisTemplate.opsForValue().get(k);
        return "k的value:"+v;
    }


    /** 设置 RedisTemplate 序列化
     *  可以设置 key 的序列化， 可以设置value的序列化
     *  可以同时设置 key 和 value的序列化
     */
    @PostMapping("/redis/addstr")
    public String addString(String k,String v){
        // 使用RedisTemplate ，在存取值之前，设置序列化
        // 设置 key 使用String的序列化, 自己可以尝试一下用Jason序列化
        // redisTemplate.setValueSerializer(RedisSerializer.json());
        //         redisTemplate.setHashValueSerializer(RedisSerializer.json());
        redisTemplate.setKeySerializer( new StringRedisSerializer());

        // 设置 value 的序列化
        redisTemplate.setValueSerializer( new StringRedisSerializer());

        redisTemplate.opsForValue().set(k,v);
        return "定义RedisTemplate对象的key，value的序列化";

    }

    // /**
    //  * 自己尝试用json的格式进行转化
    //  * https://blog.csdn.net/weixin_42001592/article/details/124054738
    //  */
    // @PostMapping("/redis/addJasonStr")
    // public String addJason(String k,String v){
    //     // 设置 Value 的序列化 - JSON 序列化 RedisSerializer.json() => GenericJackson2JsonRedisSerializer
    //     redisTemplate.setKeySerializer( new StringRedisSerializer());
    //
    //     redisTemplate.setValueSerializer(RedisSerializer.json());
    //
    //     redisTemplate.opsForValue().set(k,v);
    //
    //     return "定义RedisTemplate对象的key，value,使用Json的序列化";
    //
    // }

    /**
     * 使用json 序列化， 把java对象转为json存储
     *
     */









}
