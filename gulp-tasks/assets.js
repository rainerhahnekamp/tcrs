var gulp = require('gulp'),
  copy = require('gulp-copy'),
  paths = require('./paths');

gulp.task('assets', function() {
  return gulp.src(paths.assets)
    .pipe(copy(paths.bundle, {prefix: 2}))
});
