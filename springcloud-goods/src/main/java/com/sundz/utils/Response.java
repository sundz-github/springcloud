package com.sundz.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p> 回复实体 </p>
 *
 * @author Sundz
 * @date 2020/12/16 19:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -353366208103054376L;

    private int code;

    private String message;

    private T body;

    public Response(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.body = builder.body;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", " + body.getClass().getSimpleName() + "=" + body +
                '}';
    }

    /**
     * @class 采用Builder形式初始化数据
     */
    public static class Builder<T> {

        private int code;

        private String message;

        private T body;

        public Builder() {
        }

        public Builder<T> code(int code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> bodey(T body) {
            this.body = body;
            return this;
        }

        public Response<T> build() {
            return new Response<>(this);
        }
    }
}
