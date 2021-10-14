Page({
  getMessage: function(){
    
    wx.request({ //SSMSubmit_war_exploded/wxTest2
      url: 'http://192.168.234.248:8080/sendPLinfo', // 仅为示例，需填写自己服务器的地址
      method:"POST",
      dataType:'json',
      data: {
         uid:this.data.parking_id,//this.data.park,
         userid:this.data.parking_status,//this.data.userid,
        //  username:this.data.username,
        //  password:this.data.password
      },

      success:(res)=>{
        console.log(res.data);      //打印到控制台
        this.setData({
          userInfo : res.data.userList     //发送到wxml
        })
      }
    })

  },


})