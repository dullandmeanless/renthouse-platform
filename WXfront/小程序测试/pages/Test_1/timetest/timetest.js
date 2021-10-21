// pages/timetest/timetest.js
Page({
  data: {
    
  },


  onLoad: function (options) {
    this.timing(this)
  },

 

  timing: function (e) {
    var time = setTimeout(function () {
      e.setData({second: e.data.second + 1});
      e.timing(e);
    } , 1000)

  },
})