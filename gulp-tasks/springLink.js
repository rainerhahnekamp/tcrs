var gulp = require('gulp'),
  fs = require('fs'),
  paths = require('./paths');

gulp.task('springLink', function(cb)  {
  if (!fs.existsSync(paths.spring)) {
    fs.symlink('../../bundle/src', paths.spring, cb);
  }
  else {
    cb();
  }
});
