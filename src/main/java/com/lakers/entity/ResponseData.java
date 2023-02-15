//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lakers.entity;

import java.io.Serializable;

/**
 * @author lakers
 */
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = -7025784086948325565L;
    private Integer status;
    private String msg;
    private String traceId;
    private T data;

    public ResponseData() {
    }

    public ResponseData(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseData(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseData(Integer status, String msg, String traceId) {
        this.status = status;
        this.msg = msg;
        this.traceId = traceId;
    }


    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseData)) {
            return false;
        } else {
            ResponseData<?> other = (ResponseData) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59:
                {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label59;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label59;
                    }

                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$traceId = this.getTraceId();
                Object other$traceId = other.getTraceId();
                if (this$traceId == null) {
                    if (other$traceId != null) {
                        return false;
                    }
                } else if (!this$traceId.equals(other$traceId)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseData;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $traceId = this.getTraceId();
        result = result * 59 + ($traceId == null ? 43 : $traceId.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "ResponseData(status=" + this.getStatus() + ", msg=" + this.getMsg() + ", traceId=" + this.getTraceId() + ", data=" + this.getData() + ")";
    }
}
