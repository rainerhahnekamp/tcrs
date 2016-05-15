var gulp = require('gulp'),
  _= require('lodash'),
  fs = require('fs');

gulp.task('jspmFix', function(cb) {
  var jspm = 'app/src/jspm_packages/npm/';
  var npm = 'node_modules/';
  fs.readdir(jspm, function(err, files) {
    //fs.lstat().isSymbolicLink()
    _(files)
      .filter(function (file) {
        return fs.statSync(jspm + file).isDirectory();
      })
      .map(function (file) {
        return [file.split('@')[0], file];
      })
      .filter(function (file) {
        return !fs.existsSync(npm + file[0]);
      })
      .forEach(function(file) {
        fs.symlinkSync('../' + jspm + file[1], npm + file[0]);
      });
    cb();
  })
});
