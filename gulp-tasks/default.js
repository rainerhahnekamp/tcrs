var gulp = require('gulp'),
  runSequence = require('run-sequence');

gulp.task('default', function(cb) {
  runSequence(
    'clean',
    ['jspmFix', 'assets', 'typescript', 'sass'],
    'springLink',
    'watch',
    cb
  )
});
