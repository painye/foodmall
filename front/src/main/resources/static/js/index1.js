new Vue({
    el:"#app",

    data:{
        input2:'',
        activeIndex: '1',
        activeIndex2: '1',

        dialogVisible2:false,
        dialogVisible1:false,

        ruleForm:{
            name:'',
            pass1:'',
            pass2:''
        },
        user:{
            userId:'',
            userName:'',
            userPassword:'',
            userPhone:'',
            userImage:'',
            money:'',
            moneyPassword:'',
            userAddress:'',
            createTime:'',
            deleteEnable:'',
        },
        sc:["https://gdp.alicdn.com/imgextra/i1/392147177/O1CN01yTATzq22t73oZIYnI_!!392147177.jpg"
            ,"https://gdp.alicdn.com/imgextra/i1/392147177/O1CN01yJNN5N22t7DnpwE4T_!!392147177.jpg"
            ,"https://gjusp.alicdn.com/img/img1612263539142-996.jpg@1000y-0ic_60Q.jpg_Q75.jpg"
            ,"https://gdp.alicdn.com/imgextra/i2/619123122/O1CN01cvnlfP1YvvAdtudVu_!!619123122.jpg"
            ,"https://gdp.alicdn.com/imgextra/i1/475325704/O1CN01CbRQF81s0TlXb1MuT_!!475325704.jpg"]
    },
    methods:{
        first:function () {
            window.open("login.html")
        },
        second_first:function () {

        },
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        },
        register: function () {
            var _this=this;
            axios({
                method:"put",
                url:"http://localhost:8098/app/user/register.do",
                data:_this.user,
            }).then(function (response) {
                alert("注册成功");
            }).catch(function (error) {
                console.info(error);
            })
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => {});
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
})