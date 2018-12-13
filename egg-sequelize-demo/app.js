module.exports = app => {
    
    app.once('server', server => {
      // websocket
    });
    app.on('error', (err, ctx) => {
      // report error
    });
    app.on('request', ctx => {
      // log receive request
      console.log('---request.url---', ctx.request.url);

      console.log("app.cache", app.cache);
      
      
    });
    app.on('response', ctx => {
      // ctx.starttime is set by framework
      const used = Date.now() - ctx.starttime;
      // log total cost
      console.log("----used=", used);
    });
  };