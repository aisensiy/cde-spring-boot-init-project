var request = require('request');
var chai = require('chai');
var assert = chai.assert;
var tv4 = require('tv4');
var endpoint = process.env.ENDPOINT;

console.log(endpoint);

describe("Test", function () {
  this.timeout(60000);

  it("GET /products/{productId} -> 200", function(done) {
    var options = {
      url: endpoint + '/greeting',
      method: 'GET',
      qs: {
        name: 'test'
      },
      body: "",
      header: {}
    };

    request(options, function(error, response, body) {
      assert.isNull(error);
      assert.isNotNull(response, 'Response');
      assert.equal(response.statusCode, 200, "Expect 200, got " + response.statusCode);

      var body = JSON.parse(response.body);
      assert.equal(body.message, 'Hello, test');
      assert.isOk(/\d+/.test(body.id));
      done();
    });
  });
});
