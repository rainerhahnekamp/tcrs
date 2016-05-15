var gulp = require('gulp'),
  paths = require('./paths');

gulp.task('watch', function() {
  gulp.watch(paths.tsSource, ['typescript']);
  gulp.watch('app/src/**/*.scss', ['sass']);
  gulp.watch(paths.assets, ['assets']);
});
