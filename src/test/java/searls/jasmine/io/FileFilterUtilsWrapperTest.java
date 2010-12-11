package searls.jasmine.io;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileFilterUtils.class)
public class FileFilterUtilsWrapperTest {

	private FileFilterUtilsWrapper sut = new FileFilterUtilsWrapper();
	
	@Before
	public void powerfullyMockStaticClasses() {
		mockStatic(FileFilterUtils.class);
	}
	
	@Test
	public void suffixFileFilterDelegates() {
		String string = "blah";
		IOFileFilter expected = mock(IOFileFilter.class);
		when(FileFilterUtils.suffixFileFilter(string)).thenReturn(expected);
		
		IOFileFilter result = sut.suffixFileFilter(string);
		
		assertThat(result,is(expected));
	}
	
	@Test
	public void andDelegates() {
		IOFileFilter first = mock(IOFileFilter.class);
		IOFileFilter second = mock(IOFileFilter.class);
		IOFileFilter expected = mock(IOFileFilter.class);
		when(FileFilterUtils.and(first,second)).thenReturn(expected);
		
		IOFileFilter result = sut.and(first,second);
		
		assertThat(result,is(expected));
	}
	
	@Test
	public void orDelegates() {
		IOFileFilter first = mock(IOFileFilter.class);
		IOFileFilter second = mock(IOFileFilter.class);
		IOFileFilter expected = mock(IOFileFilter.class);
		when(FileFilterUtils.or(first,second)).thenReturn(expected);
		
		IOFileFilter result = sut.or(first,second);
		
		assertThat(result,is(expected));
	}
	
}
