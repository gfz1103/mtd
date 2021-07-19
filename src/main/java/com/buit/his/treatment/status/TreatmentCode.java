package com.buit.his.treatment.status;

/**
 * @Author weijing
 * @Date 2021-01-20 10:37
 * @Description
 **/
public class TreatmentCode {
    //状态（1 启用 0停用）
    public enum zt{
        ENABLE("1","启用"),
        DISABLE("0","停用"),
        ;

        private String code;

        private String msg;

        zt(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    //预约单状态 0 未预约1 部分预约2 全部预约3 部分执行4 完成
    public enum zlsqdzt{
        WYY("0","未预约"),
        BFYY("1","部分预约"),
        QBYY("2","全部预约"),
        BFZX("3","部分执行"),
        WC("4","完成"),
        ;

        private String code;

        private String msg;

        zlsqdzt(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    //类型（1临时 2长期）
    public enum lx{
        LS("1","临时"),
        CQ("2","长期"),
        ;

        private String code;

        private String msg;

        lx(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    //病人情况 0普通 1新病人 2需要阶段小结
    public enum brqk{
        NORMAL(0,"普通"),
        NEW_PAT(1,"新病人"),
        SUMMARY_PAT(2,"阶段小结"),
        ;

        private int code;

        private String msg;

        brqk(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    //执行状态 0未执行 1已执行
    public enum zxzt{
        WZX(0,"未执行"),
        YZX(1,"已执行"),
        ;

        private int code;

        private String msg;

        zxzt(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    //治疗记录/小结/总结表状态 1 已预约 2 已执行 3取消执行
    public enum jlxjzjzt{
        YYY("1","已预约"),
        YZX("2","已执行"),
        QXZX("3","取消执行"),
        ;

        private String code;

        private String msg;

        jlxjzjzt(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    //记录类型 1 记录2小结3总结
    public enum jllx{
        JL("1","记录"),
        XJ("2","小结"),
        ZJ("3","总结"),
        ;

        private String code;

        private String msg;

        jllx(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    //有无不良反应（1有 0无）
    public enum ywblfy{
        NO(0,"无"),
        YES(1,"有"),
        ;

        private int code;

        private String msg;

        ywblfy(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 单据来源 | 1医生开单 2药房划价 3药房退药 4医技划价 5体检开单 6收费划价 7门诊退费
     */
    public enum Djly{
        YSKD(1,"医生开单"),
        YFHJ(2,"药房划价"),
        YFTY(3,"药房退药"),
        YJHJ(4,"医技划价"),
        TJKD(5,"体检开单"),
        SFHJ(6,"收费划价"),
        MZTF(7,"门诊退费"),
        ;

        private int code;

        private String msg;

        Djly(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 项目类型 1：西药 2：成药3：草药 4检验,5检查,6手术,7治疗,8护理,9饮食,10卫材,11处置,99其他
     */
    public enum Xmlx{
        XY(1,"西药"),
        CHY(2,"成药"),
        CY(3,"草药"),
        JY(4,"检验"),
        JC(5,"检查"),
        SS(6,"手术"),
        ZL(7,"治疗"),
        HL(8,"护理"),
        YS(9,"饮食"),
        WC(10,"卫材"),
        CZ(11,"处置"),
        QT(99,"其他"),
        ;

        private int code;

        private String msg;

        Xmlx(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 执行判别 0 1
     */
    public enum Zxpb{
        WZX(0,"未执行"),
        YZX(1,"已执行"),
        ;

        private int code;

        private String msg;

        Zxpb(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 作废判别 0 1
     */
    public enum Zfpb{
        WZF(0,"未作废"),
        YZF(1,"已作废"),
        ;

        private int code;

        private String msg;

        Zfpb(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 处方标志 0 1
     */
    public enum Cfbz{
        NO(0,"否"),
        YES(1,"是"),
        ;

        private int code;

        private String msg;

        Cfbz(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 单据状态  0暂存，1提交，2预约，3已检查，4已报告，5已审核，6再审，7打印 9退回(与YS_JC01表JCZT值一致) 20.收费 21 退费
     */
    public enum Djzt{
        ZC(0,"暂存"),
        TJ(1,"提交"),
        YY(2,"预约"),
        YJC(3,"已检查"),
        YBG(4,"已报告"),
        YSH(5,"已审核"),
        ZS(6,"再审"),
        DY(7,"打印"),
        TH(9,"退回"),
        SF(10,"收费"),
        TF(11,"退费"),
        ;

        private int code;

        private String msg;

        Djzt(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public enum Ztbz{
        NO(0,"非组套标志"),
        YES(1,"组套标志"),
        ;

        private int code;

        private String msg;

        Ztbz(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
