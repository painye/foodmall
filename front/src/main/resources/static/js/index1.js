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
        ruleForm2:{
            name:'',
            pass:''
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
        commoditys:[],
        commodity: {
            id:'',
            comNumber:'',
            comName:'',
            category: {
                categoryId:'',
                categoryName:'',
                categoryMessage:'',
                composition:''
            },
            message:'',
            price:'',
            image:'',
            exTime:'',
            taste:'',
            mfrsNumber:'',
            pack:'',
            weight:'',
            grade:'',
            createTime:'',
            updateTime:'',
            deleteEnable:''
        },
        sc:["https://gdp.alicdn.com/imgextra/i1/392147177/O1CN01yTATzq22t73oZIYnI_!!392147177.jpg"
            ,"https://gdp.alicdn.com/imgextra/i1/392147177/O1CN01yJNN5N22t7DnpwE4T_!!392147177.jpg"
            ,"https://gjusp.alicdn.com/img/img1612263539142-996.jpg@1000y-0ic_60Q.jpg_Q75.jpg"
            ,"https://gdp.alicdn.com/imgextra/i2/619123122/O1CN01cvnlfP1YvvAdtudVu_!!619123122.jpg"
            ,"https://gdp.alicdn.com/imgextra/i1/475325704/O1CN01CbRQF81s0TlXb1MuT_!!475325704.jpg"]
    },
    mounted: function (){
        var _this = this;
        var myUrl = window.location.href;
        var user_id = myUrl.substr(myUrl.lastIndexOf("=")+1);
        if(user_id !=null){
            axios({
                method:"get",
                url:"http://localhost:8098/app/user/selectUserById.do?userId="+user_id,
            }).then(function (response) {
                _this.user = response.data;
            }).catch(function (error) {
                console.info(error);
            })
        }
        axios.get("http://localhost:8099/app/food/commodity/selectAllCom.do")
            .then(function (response){
                _this.commoditys = response.data;
            })
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
        login: function () {
            var _this=this;
            axios({
                method:"get",
                url:"http://localhost:8098/app/user/logon.do?"+"userName="+_this.user.userName+"&"+"userPassword="+_this.user.userPassword,
            }).then(function (response) {
                _this.user = response.data;
                alert(_this.user.userName+"登录成功")
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
